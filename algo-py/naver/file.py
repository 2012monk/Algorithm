def s(p):
    tmp = []
    for f in p:
        name = f.split('/')[-1].split('.')

        o = name[0].split('_')[0] + '.' + name[1]
        tmp.append(o)

    print(tmp)

    cnt = {}
    res = []

    for f in tmp:
        if not f in res:
            res.append(f)
        cnt[f] = cnt.get(f, 0) + 1

    result = []
    for f in res:
        if cnt[f] > 1:
            result.append(f)
            result.append(str(cnt[f]))

    print(result)


n = ['a_v4.x', 'a_v.x', 'a_v.x', 'a/a/a/a_df.v']
s(n)
