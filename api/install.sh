#!/bin/bash
conda env create --file environment.yaml
bash <(curl -s https://raw.githubusercontent.com/konlpy/konlpy/master/scripts/mecab.sh)
conda activate ml
