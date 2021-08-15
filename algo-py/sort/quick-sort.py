class Sort:
    @staticmethod
    def _partition(arr, lo, hi):
        pivot = arr[hi]
        left = lo
        for right in range(lo, hi):
            if arr[right] < pivot:
                arr[left], arr[right] = arr[right], arr[left]
                left += 1
        arr[left], arr[hi] = arr[hi], arr[left]
        return left

    def _quick(self, arr, lo, hi):
        if lo >= hi:
            return
        pivot = self._partition(arr, lo, hi)
        self._quick(arr, lo, pivot - 1)
        self._quick(arr, pivot + 1, hi)

    def quickSort(self, arr):
        self._quick(arr, 0, len(arr) - 1)


s = Sort()
arr = [6, 5, 4, 23, 7, 1]
print(arr)
s.quickSort(arr)
print(arr)
