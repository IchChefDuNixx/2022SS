_Exercise assignment for the course [Introduction to AI (partII)](https://inf-git.fh-rosenheim.de/aai-ai2/hsro-aai-ai2-github-io) in the [Bachelor of AAI](https://www.th-rosenheim.de/en/technology/computer-science-mathematics/applied-artificial-intelligence-bachelors-degree) at [Rosenheim University of Applied Sciences](http://www.th-rosenheim.de)_


# 10 - Applications of NLP

For this exercise you can find some hints within the provided Jupyter Notebooks.

**Solution is provided within the branch "musterloesung".**

## Task 1: Preprocessing

In the exercise we will be looking at a corpus of twitter tweets:

```python
import numpy as np
import pandas as pd
import nltk
from nltk.corpus import webtext
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from nltk.corpus import twitter_samples
import string

nltk.download('webtext')
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')

nltk.download('twitter_samples')

tweets_raw = twitter_samples.strings('tweets.20150430-223406.json')
tweets_raw[:5]

# The default tokenizer for Tweets is specialised for 'casual' text, and the 
# tokenized() method returns a list of lists of tokens.
tweets_tok = twitter_samples.tokenized('tweets.20150430-223406.json')
tweets_tok[:3]
```

Preprocess this corpus of twitter tweets:
- Tokenization
- Lemmatization
- Stop words removal

To do so please convert the code into Jupyter Notebook and apply the steps form lecture!

>Note: You can cross-check with the Jupyter Notebook with wine reviews (https://inf-git.fh-rosenheim.de/aai-ai2/10_exercise/-/blob/main/nlp_part1.ipynb)!

## Task 2: Compute similar twitter tweets by using TF-IDF

The following setup snippet should help you on getting it working:

```python
import numpy as np
import pandas as pd
import nltk
from nltk.corpus import webtext
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from nltk.corpus import twitter_samples
import string
from sklearn.feature_extraction.text import TfidfVectorizer, CountVectorizer, TfidfTransformer
from sklearn.metrics.pairwise import cosine_similarity
import pickle

nltk.download('webtext')
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')
nltk.download('twitter_samples')

# read the preprocessed data
with open('tweets_lem.data', 'rb') as filehandle:
    tweets_lem = pickle.load(filehandle)
    
tweets_raw = twitter_samples.strings('tweets.20150430-223406.json')
```

You can find the `tweets_lem.data` within this repo. Just place it next to your code!

>Note: You can cross-check with the Jupyter Notebook with wine reviews (https://inf-git.fh-rosenheim.de/aai-ai2/10_exercise/-/blob/main/nlp_part1.ipynb)!
