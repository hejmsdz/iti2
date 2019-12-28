import sys
import pandas

if __name__ == '__main__':
    tweets = pandas.read_csv(sys.argv[1])
    for tweet in tweets.Tweet:
        hashtags = [word for word in tweet.split(' ') if word and word[0] == '#']
        if hashtags:
            print(hashtags)
