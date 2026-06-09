class MovingAverage:

    def __init__(self, size: int):

        self.size = size
        self.queue = deque()
        
    def next(self, val: int) -> float:

        total = 0;

        self.queue.append(val)

        if len(self.queue) > self.size:
            self.queue.popleft()

        for num in self.queue:
            total += num
        
        return total / len(self.queue)
            
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)
