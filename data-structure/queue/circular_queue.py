class CircularQueue:
    def __init__(self, init_size):
        self.front = 0
        self.rear = 0
        self.q = [None] * init_size
        self.max_size = init_size

    def enQueue(self, val):
        self.q[self.rear] = val
        self.rear = (self.rear + 1) % self.max_size

    def deQueue(self) -> object:
        val = self.q[self.front]

        if self.front < self.rear:
            self.front = (self.front + 1) % self.max_size

        return val


