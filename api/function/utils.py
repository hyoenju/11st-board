import re
import konlpy
import numpy as np
from gensim.models import Word2Vec

def preprocessing(sentence, mecab):
  sentence = re.sub('. ;,/~=%:\(-_+\)\[]"*‥ㆍ狂氣·>…&#’‘@$☆→×崧`<≪≫中△⊙★福幸祝婚結♪▽《》\\♬', '', str(sentence))
  sentence = re.sub('[0-9]', '', str(sentence))
  sentence = re.sub(' +', ' ', str(sentence))
  sentence = sentence.strip()

  extracted_words = []
  for word in mecab.pos(sentence):
    word_pos = word[1]
    if (word_pos in ['NNP', 'NNG', 'NP', 'NR', 'VV', 'VV+EC', 'VA', 'NNBC', "SF", "MAG"]) or (word_pos.startswith("VA+")):
      extracted_words.append(word[0])
  return extracted_words

def make_feature_vec(sentence, model):
  feature_vec = np.zeros((30,),dtype="float32")  # pre-initialize (for speed)
  nwords = 0
  index2word_set = set(model.index_to_key)  # words known to the model
  words = sentence.split(' ')
  for word in words:
    if word in index2word_set:
      nwords = nwords + 1
      feature_vec = np.add(feature_vec,model[word])

  feature_vec = np.divide(feature_vec, nwords)

  return feature_vec

def get_weighted_average(score_list, sentence_len_list):
  score_sum = 0
  for i in range(len(score_list)):
    score_sum += sentence_len_list[i] * score_list[i]
  return score_sum / sum(sentence_len_list)