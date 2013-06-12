class Node:
    def __init__(self, item):
        self.item = item
        self.next = nil

    def __str__(self):
        return "(" + self.item + ")"

class LinkedList:
    def __init__(self):
        self.head = nil

    def __str__(self):
        ret = ""
        i = head

        while i.next != nil:
            ret += str(i)

        return ret

