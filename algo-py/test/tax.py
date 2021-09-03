import math


def tax(orderAmount, taxFreeAmount, serviceAmount):
    total = orderAmount - serviceAmount
    supplyAmount = (total + (taxFreeAmount / 10)) / 11
    print(supplyAmount * 10)
    vat = orderAmount - supplyAmount * 10
    print(math.ceil(vat))


order = 120
sf = 0
tf = 20
tax(order, tf, sf)
