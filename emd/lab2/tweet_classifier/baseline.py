import numpy as np
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.svm import LinearSVC
from sklearn.metrics import accuracy_score

def train_model(train, **kwargs):
    vectorizer = TfidfVectorizer(binary=False, ngram_range=(1, 3))
    classifier = LinearSVC(class_weight='balanced', **kwargs)
    
    train_bow = vectorizer.fit_transform(train.Tweet)
    classifier.fit(train_bow, train.Category)
    
    return vectorizer, classifier

def predict(model, data):
    vectorizer, classifier = model
    bag_of_words = vectorizer.transform(data.Tweet)
    predictions = classifier.predict(bag_of_words)
    return predictions

def train_and_evaluate(train, test, metric=accuracy_score, **kwargs):
    model = train_model(train, **kwargs)
    predictions = predict(model, test)
    return metric(test.Category, predictions)

def optimize(tweets, cv_folds=5):
    batches = np.random.randint(0, cv_folds, len(tweets))

    best_c = None
    best_accuracy = 0
    for c in [0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10]:
        accuracies = []
        for i in range(cv_folds):
            train_idx = batches != i
            test_idx = batches == i
            acc = train_and_evaluate(tweets[train_idx], tweets[test_idx], C=c)
            accuracies.append(acc)

        mean = np.mean(accuracies)
        if mean > best_accuracy:
            best_c = c
            best_accuracy = mean
    
    return { 'C': best_c }, best_accuracy

if __name__ == '__main__':
    from .dataset import load_training, load_test, save_predictions
    from .cleanup import cleanup
    from .preprocess import preprocess_dataframe

    tweets = load_training()
    tweets = cleanup(tweets)
    tweets = preprocess_dataframe(tweets)

    params, cv_accuracy = optimize(tweets)
    print(params, cv_accuracy)
    model = train_model(tweets, **params)
    
    test_tweets = load_test()
    test_tweets = preprocess_dataframe(test_tweets)
    test_tweets['Category'] = predict(model, test_tweets)
    save_predictions('baseline_predictions.csv', test_tweets)
