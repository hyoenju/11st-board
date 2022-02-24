from typing import Optional

from fastapi import FastAPI

app = FastAPI()


@app.get("/")
def read_root():
    return {"Hello": "World"}



@app.get("/ml")
def predict(q: Optional[str] = None):
    pred = 0.99
    return {"q": q, "pred": pred}