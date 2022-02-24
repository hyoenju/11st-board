# 11ST-Board Machine Learning API

- 본 문서는 11st-board 프로젝트에 필요한 machine learning Model API 개발을 위한 환경을 설정하기 위한 문서입니다.


## Requirements

- miniconda
- python 3.8
- fastAPI


## Setting up

### 가상환경

1.  miniconda 설치하기

- 독립된 개발 환경을 구성하기 위해 conda를 사용합니다.
- [miniconda 다운로드 링크](https://docs.conda.io/en/latest/miniconda.html#) 로 들어가 설치 파일을 다운받고 miniconda 를 설치합니다.

2. 가상환경 생성/실행하기

- 아래 명령어를 입력하여 가상환경을 생성 및 실행합니다. 가상환경 안에는 api 실행에 필요한 패키지가 모두 설치되어 있습니다.

- 실행 전
  ``` zsh
  (base) » source install.sh
  ```

- 실행 후 <sub> (* 터미널 종류에 따라 다르게 표시될 수 있습니다. )</sub>
  ``` zsh
  (ml) » 
  ```

### FastAPI

1. fastAPI 서버 실행하기
- 터미널에서 아래 명령어를 입력합니다.(main.py 위치에서 실행)
  ``` zsh
  uvicorn main:app --reload
  ```

2. 실행 확인하기
- 브라우저 : http://127.0.0.1:8000/ml?content=test
- 대화형 API 문서  : http://127.0.0.1:8000/docs


## References
- FastAPI Tutorial : https://fastapi.tiangolo.com/ko/