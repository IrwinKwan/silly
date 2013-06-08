import os

with open(os.path.join(".", "touch.txt"), "w") as handle:
    print >> handle, "Hello world!"
