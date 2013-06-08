class Stack:
    def __init__(self):
        self.theStack=[]

    def top(self):

        if self.isEmpty():
            return "Empty Stack"
        else:
            return self.theStack[-1]

    def isEmpty(self):
        return len(self.theStack)==0

    def push(self,item):
        self.theStack.append(item)

    def pop(self):
        if not self.isEmpty():
            temp=self.theStack[-1]
            del(self.theStack[-1])
            return temp

        else:
            return "Empty Stack"


OPERATOR = ["+", "-", "*", "/"]


def evaluatePostfix(infix):

    eStack = Stack()

    postfix = ""
    a_number = None

    for n in infix:

        if n not in OPERATOR and n is not "(" and n is not ")":
            if a_number is None:
                a_number = n
            else:
                a_number = a_number + n

        elif n is ")":
            if a_number is not None:
                postfix += a_number + " "
                a_number = None
            postfix += eStack.pop() + " "

        elif n in OPERATOR:
            if a_number is not None:
                postfix += a_number + " "
                a_number = None

            eStack.push(n)

    print postfix

if __name__ == "__main__":
    evaluatePostfix("(((54+56)+(4+73))+(9+7))")
    evaluatePostfix("(6+4)")
    evaluatePostfix("((6+4+5) + 10)")
