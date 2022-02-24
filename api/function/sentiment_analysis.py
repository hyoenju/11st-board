from function.utils import *
import joblib
import kss

mecab = konlpy.tag.Mecab()
model = Word2Vec.load("model/word2vec_dim30_conversation_naverReview.model")
lgbm_clf = joblib.load("model/lgbm_clf.pkl")

def predict_sentence_score(sentence):
  sen_prepro = preprocessing(sentence, mecab)
  sen_prepro_join = ' '.join(sen_prepro)
  sen_emb = make_feature_vec(sen_prepro_join, model.wv).reshape(1, -1)
  score = lgbm_clf.predict_proba(sen_emb)[0][1]
  return score

def predict_content_score(content):
  sentences = kss.split_sentences(content)
  score_list = list(map(predict_sentence_score, sentences))
  sentence_len_list = list(map(len, sentences))
  return round(get_weighted_average(score_list, sentence_len_list), 2)