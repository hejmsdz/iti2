vectorizer_file = 'models/vectorizer.bin'
classifier_file = 'models/classifier.bin'
test_data_file = 'data/test.csv'
output_file = 'predictions.csv'

with open(vectorizer_file, 'rb') as f:
    vectorizer = pickle.load(f)

with open(classifier_file, 'rb') as f:
    model = pickle.load(f)

test = pandas.read_csv(test_data_file, dtype={'Id': str, 'Tweet': str})
test = test.dropna()
test_x = vectorizer.transform(test.Tweet).toarray()

test['Category'] = model.predict(test_x)

with open(output_file, 'wt') as f:
    f.write("Id,Category\n")
    for i, row in test.iterrows():
        print(f"{row.Id},{row.Category}\n")
