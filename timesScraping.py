import requests 

def fetchAndSaveToFile(url, path):
    r = requests.get(url)
    with open(path, "w") as f:
        f.write(r.text)

url = "https://www.theknowledgeacademy.com/blog/how-to-run-python-scripts/#:~:text=To%20run%20Python%20Scripts%2C%20you,%22%20with%20the%20actual%20filename)."
fetchAndSaveToFile(url, "data/times.html")

from bs4 import BeautifulSoup
with open ("data/times.html", "r") as f:
    html_doc = f.read()

soup = BeautifulSoup(html_doc, 'html.parser')

#//format the html content
#print(soup.prettify())

#print the text of the title without <title>
#print(soup.title.text)
#print(soup.title.string)

#print type of title
#print(type(soup.title))

#name of the parent (head)
#print(soup.title.parent.name)

#gives me the first anchor tag
#print(soup.a)

#all content of all anchor tags
#print(soup.find_all('a'))

#print only href 
#count = 0
#for link in soup.find_all('a'):
 #   print(link.get('href'))
  #  count +=1

#just for fun, counting hrefs
#print(count)

#print the text of the page
#print(soup.get_text())

#accessing all paragraphs
#for link in soup.find_all('p'):

    #skip all the classes with none value
   # if link.get('class') is None:
    #    continue
    #print(link.get('class'))

#print text of all paragraphs, you surely need a loop
#for link in soup.find_all('p'):
 #   print(link.get_text())

 #print the paragraph's parent name
#print(soup.p.parent.name)

#finding through ID
#s = soup.find(id="overlays")
#print(s.text)

# < -------------------------------Advanced ---------------------------------------------->

#print all the text from div where class is header-top
#we are using . because we are targeting "class" of div
#for text in soup.select('div.header-top'):
 #   print(text.get_text())


#printing the tags adn their content inside the div that has id = "menuToggle"
#we have used the # because menuToggle is the ID of the div tag
#for text in soup.select('div#menuToggle'):
 # print(text)

#printing the tag that contains this id
# print(soup.find(id = 'menuToggle'))

#----------------------------------------mere kaam ki cheezen


#----------------------cheez 1

#I got all the links of the webpage
file = open("data/timesLinks.txt", "w") 

for link in soup.find_all('a'):
    href = link.get('href')
    if href == 'javascript:void(0)' or href is None:
     continue
    file.write(href)
    file.write("\n") 

file.close()



















    


