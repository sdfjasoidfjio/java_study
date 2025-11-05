def sum_nums(*number):
    print(len(number), "개의 인자 ", number)
    print("합계: ", sum(number), ", 평균 : ", sum(number)/len(number))

def min_nums(*number):
    print("최솟값은", min(number))


sum_nums(10,20,30)
sum_nums(10,20,30,40,50)
min_nums(20, 40, 50, 10)
