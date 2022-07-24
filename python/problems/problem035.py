import math

def shift_list(input, amount):
    # Emulate pass by value to prevent issues where the reference is updated.
    copy = input.copy()
    # Underscore = invisible variable.
    for _ in range(0, amount):
        first_digit = copy.pop(0)
        copy.append(first_digit)
    return copy

def get_rotations(x):
    rotations = []
    splitted = [int(digit) for digit in str(x)]
    for i in range(0, len(splitted)):
        shifted = shift_list(splitted, i)
        shifted_joined = int(''.join([str(digit) for digit in shifted]))
        rotations.append(shifted_joined)
    return rotations

def is_prime(x):
    if x <= 1:
        return False
    for i in range(2, int(math.sqrt(x)) + 1):
        if x % i == 0:
            return False
    return True

def is_circular_prime(x):
    rotations = get_rotations(x)
    for rotation in rotations:
        if not is_prime(rotation):
            return False
    return True

if __name__ == "__main__":
    circular_primes = []
    for i in range(0, 999_999):
        if is_circular_prime(i):
            circular_primes.append(i)
    print(len(circular_primes))
