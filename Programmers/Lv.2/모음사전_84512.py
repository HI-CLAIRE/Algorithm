from itertools import product
word = input()

def solution(word):
	vowels = ["A", "E", "I", "O", "U"]
	perms = []
	for i in range(1, 6):
		for p in product(vowels, repeat=i):
			word_perm = ''.join(map(str, p))
			perms.append(word_perm)
	perms.sort()
	ans = perms.index(word)
	return ans + 1

print(solution(word))