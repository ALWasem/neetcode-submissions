class Solution:
    def lengthOfLastWord(self, s: str) -> int:

        a = s[::-1]

        count = 0
        isFirst = True

        for c in a:
            
            if c != " ":
                count += 1
                isFirst = False;
            elif c == " " and not isFirst:
                break

        return count

