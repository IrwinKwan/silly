def tokenize(s):
  import re
  pattern = re.compile("\s*(\-|\+=|==|=|\+)\s*")
  return pattern.split(s)

print(tokenize("hello-+==== =+  there"))

print "b-bb--b".split("-")