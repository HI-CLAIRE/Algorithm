record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]

dic = {}

for x in record:
    tmp = x.split()
    if tmp[0] == "Enter":
        dic[tmp[1]] = tmp[2]
    elif tmp[0] == "Change":
        dic[tmp[1]] = tmp[2]

msg_list = []
for y in record:
    new_tmp = y.split()
    if new_tmp[0] == "Enter":
        msg_list.append(f"{dic.get(new_tmp[1])}님이 들어왔습니다.")
    elif new_tmp[0] == "Leave":
        msg_list.append(f"{dic.get(new_tmp[1])}님이 나갔습니다.")

for msg in msg_list:
    print(msg)


