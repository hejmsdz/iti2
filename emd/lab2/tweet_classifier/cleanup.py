def cleanup(tweets):
    tweets = tweets.dropna()
    tweets = tweets.drop(columns=['Id'])
    tweets = tweets[tweets.Category != 'Tweet']
    tweets = tweets[tweets.Tweet != 'Not Available']
    tweets = tweets[tweets.Tweet != '']
    return tweets
