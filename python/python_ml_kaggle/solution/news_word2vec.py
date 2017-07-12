# _*_ coding:utf-8 _*_

from sklearn.datasets import fetch_20newsgroups

from bs4 import BeautifulSoup
import nltk, re
from gensim.models import word2vec


news = fetch_20newsgroups(subset='all')
X, y = news.data, news.target

def news_to_sentences(news):
    news_text = BeautifulSoup(news).get_text()

    tokenizer = nltk.data.load('tokenizers/punkt/english.pickle')
    raw_sentences = tokenizer.tokenize(news_text)

    sentences = []

    for sent in raw_sentences:
        sentences.append(re.sub('[^a-zA-Z]', ' ', sent.lower().strip()).split())

    return sentences

sentences = []

for x in X:
    sentences += news_to_sentences(x)

len(sentences)

# Set values for various parameters
num_features = 300    # Word vector dimensionality
min_word_count = 20   # Minimum word count
num_workers = 2     # Number of threads to run in parallel
context = 5        # Context window size
downsampling = 1e-3   # Downsample setting for frequent words

# Initialize and train the model (this will take some time)
from gensim.models import word2vec

model = word2vec.Word2Vec(sentences, workers=num_workers, \
                          size=num_features, min_count = min_word_count, \
                          window = context, sample = downsampling)

# If you don't plan to train the model any further, calling
# init_sims will make the model much more memory-efficient.
model.init_sims(replace=True)

# print model.most_similar('morning')
# print model.most_similar('email')
print model.most_similar('university')


