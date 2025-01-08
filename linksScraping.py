import sys
import requests 

def fetchAndSaveToFile(url, path):
    r = requests.get(url)
    with open(path, "w") as f:
        f.write(r.text)

url = sys.argv[1]
#url = "https://www.iba-suk.edu.pk/"
#url = "https://www.theknowledgeacademy.com/blog/how-to-run-python-scripts/#:~:text=To%20run%20Python%20Scripts%2C%20you,%22%20with%20the%20actual%20filename)."
fetchAndSaveToFile(url, "data/fetched.html")

from bs4 import BeautifulSoup
with open ("data/fetched.html", "r") as f:
    html_doc = f.read()

soup = BeautifulSoup(html_doc, 'html.parser')

#I got all the links of the webpage
file = open("data/Links.txt", "w") 

for link in soup.find_all('a'):
    href = link.get('href')
    if href == 'javascript:void(0)' or href is None or href == '#':
     continue
    file.write(href)
    file.write("\n") 

file.close()



















    


