import sys
import requests 

def fetchAndSaveToFile(url, path):
    r = requests.get(url)
    with open(path, "w") as f:
        f.write(r.text)

url = sys.argv[1]

fetchAndSaveToFile(url, "data/fetched.html")

from bs4 import BeautifulSoup
with open ("data/fetched.html", "r") as f:
    html_doc = f.read()

soup = BeautifulSoup(html_doc, 'html.parser')

file = open('data/Title.txt', 'w')
file.write((soup.title.text))
file.write('\n')
file.close()



    



