#!/usr/bin/env python

# Slice a 

import csv
import numpy
import itertools

p = csv.reader(open('file.csv'), delimiter=',')
a = [0]*2881
a = numpy.array(a, dtype=dict)
for row in p:
    print row
    if row[0] == "200":
        a = [row] + list(itertools.islice(p, 10))

print a


