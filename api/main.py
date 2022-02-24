from typing import Optional

from fastapi import FastAPI

from function.sentiment_analysis import *

app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "World"}

@app.get("/ml")
def predict(content: Optional[str] = None):
    score = predict_content_score(content)
    return {"content": content, "score": score}