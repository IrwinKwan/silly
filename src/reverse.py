if __name__ == "__main__":
    s = "Hello there."

    first = 0
    last = len(s) - 1

    print s

    while (first < last):
        tmp = s[first]
        s[first] = s[last]
        s[last] = tmp

    print s

    
