import re
import numpy as np

production = np.zeros((6, 7), dtype=int)
sales = np.zeros((6, 7), dtype=int)
storage = np.zeros((6, 7), dtype=int)

variables = { 'production': production, 'sales': sales, 'storage': storage }

with open('out.txt', 'r') as f:
    for line in f:
        match = re.match(r'(\w+)#(\d+)#(\d+)\s+(\d+)', line)
        var, i, j, val = match.groups()
        variables[var][int(j) - 1, int(i) - 1] = int(val)

for key, table in variables.items():
    print(key)
    print()
    print('\n'.join(['\t'.join(map(str, row)) for row in table]))
    print()
