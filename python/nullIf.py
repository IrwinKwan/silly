class Node:
	def __init__(self, item):
		self.value = item
		self.next = None

	def __str__(self):
		return str(self.value)

class MyList:
	def __init__(self):
		self.head = None

	def __str__(self):
		ret = ""

		i = self.head
		while i != None:
			ret += str(i) + " -> "
			i = i.next

		return ret

	def insertSorted(self, item):
		if self.head == None or item < self.head.value:
			me = Node(item)
			me.next = self.head
			self.head = me
		else:
			i = self.head
			while i.next != None and item > i.next.value:
				i = i.next

			me = Node(item)
			me.next = i.next
			i.next = me

def testNullIf():
	a = Node(1)
	b = Node(2)
	a.next = b
	head = a

	if a.next != None and a.next.value > 1:
		print a.next.value
	else:
		print "False!"

	if b.next != None and b.next.value > 1:
		print b.next.value
	else:
		print "False!!!"

print "List section!"
l = MyList()
print l

print "Inserting 1"
l.insertSorted(1)
print l

l.insertSorted(3)
l.insertSorted(2)
print l

print "Done"
