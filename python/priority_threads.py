#!/bin/env python
from collections import deque
from collections import defaultdict
import random
import pprint

class Threads:
	def __init__(self):
		self.threads = defaultdict(int) # A dictionary of threads keyed by ID

	def insert(self, key):
		self.threads[key] += 1

	def __str__(self):
		ret = ''
		for k, v in self.threads.iteritems():
			ret += "[%d] = %d\n" % (k, v)

		return ret

class PriorityThreads:
	def __init__(self, size):
		self.maxsize = size
		self.priority = deque() # List of Thread Keys. array index serves as the priority order.

	def update(self, key):
		if key in self.priority:
			# delete the key from the list
			x = self.priority.remove(key)

		elif self.maxsize <= len(self.priority):
			self.priority.pop()

		self.priority.appendleft(key)

	def __str__(self):
		return str(self.priority)

if __name__ == '__main__':
	t = Threads()
	p = PriorityThreads(4)

	# We'd probably ideally have an object for MailClient or something that does an update
	for i in range(1,30):
		new_thread = random.randint(1,6)

		print new_thread

		t.insert(new_thread)
		p.update(new_thread)

		print p
		print t


