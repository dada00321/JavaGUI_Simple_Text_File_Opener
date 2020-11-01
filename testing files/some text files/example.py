import time

def judge_the_week(start_month=3,start_day=2):
    today_month, today_day = time.localtime()[1], time.localtime()[2]
    print("今天是第 {} 周~".format(get_course_week_num(start_month, start_day, today_month, today_day)))

def is_leap_year(year):
    if (not year%400) or (not year%4 and year%100): return True
    return False

def get_course_week_num(m1,d1,m2,d2): # y1=y2
    days = [31,28,31,30,31,30,31,31,30,31,30,31]
    if is_leap_year(time.localtime()[0]): days[1] = 29
    #-------------------------
    week_count = 0
    #-------------------------
    day = d1
    month = m1
    while month <=m2:
        #print("month:", month)
        while day <= days[month-1]:
            week_count += 1
            #print(day)
            if month==m2 and d2 in range(day, day+7):
                #print("\n{}\n".format("done"))
                break
            day += 7
        day -= days[month-1]
        #print()
        month+=1
    #-------------------------
    return week_count

if __name__ == "__main__":
    judge_the_week(9,14)