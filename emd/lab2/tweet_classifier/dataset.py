import pandas

def load(path, labeled=True):
    dtype = {'Id': str, 'Tweet': str}
    if labeled:
        dtype['Category'] = str
    
    return pandas.read_csv(path, dtype=dtype)

def load_training():
    return load('data/train.csv', True)

def load_test():
    return load('data/test.csv', False)

def save_predictions(path, tweets):
    with open(path, 'wt') as f:
        f.write("Id,Category\n")
        for i, row in tweets.iterrows():
            f.write(f"{row.Id},{row.Category}\n")
