import re
from nltk.tokenize.casual import casual_tokenize
from nltk.stem.porter import PorterStemmer
from nltk.stem import WordNetLemmatizer
from nltk.tag import pos_tag
from nltk.corpus import stopwords
import string

stops = {'in', 'of', 'at', 'a', 'the', 'to', 'on', 'and', 'it'}
stops.update(string.punctuation)
stops.difference_update('?!')

stemmer = PorterStemmer()
lemmatizer = WordNetLemmatizer()

def tag_for_lemmatizer(tag):
    if tag.startswith('NN'):
        return 'n'
    if tag.startswith('VB'):
        return 'v'
    return 'a'

def preprocess(text, lemmatize=True):
    if not text or type(text) != str:
        return ''

    text = text.lower()
    text = re.sub(r"https?://[^\s]+", '', text) # hyperlinks
    text = re.sub(r"\@\w+", '', text) # mentions
    text = re.sub(r"#", '', text) # hashtags
    text = re.sub(r"\d+\w*", '', text) # numbers
    text = re.sub(r"'s", '', text) # possesive
    text = re.sub(r"n't", ' not', text) # contractions
    
    words = [word for word in casual_tokenize(text) if word not in stops]
    
    if lemmatize:
        words = [
            lemmatizer.lemmatize(word, tag_for_lemmatizer(tag))
            for word, tag in pos_tag(words)
        ]
    else:
        words = [
            stemmer.stem(word)
            for word in words
        ]
    text = ' '.join(words)
    return text

def preprocess_dataframe(tweets):
    tweets.Tweet = tweets.Tweet.apply(preprocess)
    return tweets
