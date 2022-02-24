#!/bin/bash
conda env create --file environment.yaml
conda activate ml
bash <(curl -s https://raw.githubusercontent.com/konlpy/konlpy/master/scripts/mecab.sh)
