from collections import deque

class Node:
	def __init__(self, item):
		self.value = item
		self.left = None
		self.right = None

	def __str__(self):
		return "(" + str(self.value) + ")"

def op(token):
	return (token == '+' or token == '-' or token == '*' or token == '/')

class Tree:
	def __init__(self):
		self.root = None
		self.ops = [] # Treat this as a stack with append and pop
		self.nums = None # Use this space to store a number (or pointer)

	def load_prefix(self, expr):
		tokens = expr.split(" ")
		self.nums = None
		# + + * 4 5 1 2
		# (+ (+ (* 4 5) 1) 2)

		for t in tokens:
			if op(t):
				self.ops.append(t)
			else: # assume that it's a number for now... we could easily do a check if we wanted to

				if self.nums == None:
					self.nums = Node(t)
				else:
					# we have enough operands, so let's get our operator
					op_node = Node(self.ops.pop(0))

					new_left = self.nums
					new_right = Node(t)

					op_node.left = new_left
					op_node.right = new_right

					self.nums = op_node

		self.root = self.nums

	def printTree(self):
		i = self.root
		while i != None:
			print str(i)
			i = i.left
			print str(i)
			i = i.right
			print str(i)

if __name__ == '__main__':
	my_tree = Tree()
	my_tree.load_prefix("+ + * 4 5 1 2")
	print "GO GO GO"
	my_tree.printTree()
