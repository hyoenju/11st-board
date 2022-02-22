# ML API

본  문서는 machine learning 모델 API 를 구축, 실행 환경을 구축하기 위한 문서입니다.

- conda
- python 3.10
- fastAPI

### 가상환경 설정
1.  miniconda 설치하기
독립된 개발 환경을 구성하기 위해 conda를 사용합니다.
[miniconda 설치 링크](https://docs.conda.io/en/latest/miniconda.html#) 로 들어가 miniconda 를 설치합니다.


2. 가상환경 생성하기
- yaml 을 이용해서 가상환경을 생성합니다.
    ``` zsh
    (base) » conda env create --file environment.yaml
    ```

3. 가상환경 실행하기
- 실행 전
  ``` zsh
  (base) » conda activate ml
  ```
- 실행 후
  ``` zsh
  (ml) » 
  ```
  <sub> (* 터미널 환경에 따라 다르게 표시될 수 있습니다.)
  (가상환경 안에는 api 실행에 필요한 패키지가 모두 설치되어 있습니다.)</sub>

### FastAPI 
1. fastAPI 서버 실행하기
- 터미널에서 아래 명령어를 입력합니다.(main.py 위치에서 실행)
  ``` zsh
  uvicorn main:app --reload
  ```

2. 실행 확인하기
 - 브라우저 : http://127.0.0.1:8000/ml?q=test
 - 대화형 API 문서  : http://127.0.0.1:8000/docs


### Reference
- FastAPI Tutorial : https://fastapi.tiangolo.com/ko/