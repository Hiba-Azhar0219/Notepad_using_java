import requests 

def fetchAndSaveToFile(url, path):
    r = requests.get(url)
    with open(path, "w") as f:
        f.write(r.text)

url = "https://www.iba-suk.edu.pk/"
fetchAndSaveToFile(url, "data/SIBA.html")

from bs4 import BeautifulSoup
with open ("data/SIBA.html", "r") as f:
    html_doc = f.read()

soup = BeautifulSoup(html_doc, 'html.parser')

file = open('data/SIBA.txt', 'w')
for link in soup.find_all('a'):
    href = link.get('href')
    if href == '#':
        continue
    file.write(href)
    file.write('\n')
file.close()



