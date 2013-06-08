if __name__ == "__main__":
    for i in range(1,100):
        if i % 3 == 0 and i % 5 == 0:
            print str(i) + "fizzbuzz"
        elif i % 3 == 0:
            print str(i) + "fizz"
        elif i % 5 == 0:
            print str(i) + "buzz"


