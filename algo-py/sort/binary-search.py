def binary_search(arr, target, left=0, right=None):
    if right is None:
        right = len(arr) - 1
    if left > right:
        return -1
    mid = left + (right - left) // 2
    if arr[mid] > target:
        return binary_search(arr, mid + 1, right, target)
    if arr[mid] < target:
        return binary_search(arr, left, mid - 1, target)
    return mid


def binary_search(arr, target, left=0, right=None):
    if right is None:
        right = len(arr) - 1
    while left <= right:
        mid = left + (right - left) // 2
        if arr[mid] < target:
            left = mid + 1
        elif arr[mid] > target:
            right = mid - 1
        else:
            return mid
    return left
