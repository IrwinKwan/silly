# http://stackoverflow.com/questions/16203365/python-regex-matching-all-but-last-occurance

s = "./folder/thisisa.test/file.cxx.h"
n = s[::-1].index('.')

print s
print n
