import requests
import csv
from bs4 import BeautifulSoup

url = "https://finance.naver.com/sise/sise_market_sum.nhn?sosok=0&page="

fileName = "코스피_시가총액1~50위.csv"
f = open(fileName, "w", encoding="utf-8-sig", newline="")
writer = csv.writer(f)

title ="N 종목명 현재가 전일비 등락률 액면가 시가총액 상장주식수 외국인비율 거래량 PER ROE".split("\t")
print(type(title))
writer.writerow(title)

for page in range(1, 2):
    res = requests.get(url + str(page))
    res.raise_for_status()
    soup = BeautifulSoup(res.text, "html.parser")

    data_row = soup.find("table", attrs={"class": "type_2"}).find("tbody").find_all("tr")
    for row in data_row:
        columns = row.find_all("td")
        if len(columns) == 1:
            continue
        data = [column.get_text().strip() for column in columns]
        # print(data)
        writer.writerow(data)