from datetime import datetime
import requests
import math

#v primeru nove podnice, je potrebno PODNICA_ID spremeniti na ustrezno vrednost id-ja v bazi
PODNICA_ID = 1
url = "http://83.212.82.142:8081/v1"
# url = "http://localhost:8081/v1"

def poslji_meritev(vrednost, cas_meritve, tip):
    data = {
        "vrednost": vrednost,
        "cas_meritve": cas_meritve.isoformat(),
        "tip_id": tip,
        "podnica_id": PODNICA_ID
    }

    headers = {'Content-Type': 'application/json'}
    r = requests.post(url + "/meritve", json=data, headers=headers, timeout=10)
    print(r.status_code, r.url)

def poslji_sliko(ime_datoteke, cas_meritve):
    #zaradi timezone je odstetih -3600
    payload = {
        "ustvarjeno": math.floor((cas_meritve.timestamp()-3600)*1000),
        "podnica": PODNICA_ID
    }
    image = open(ime_datoteke, "rb")
    r = requests.post(url + "/varoa", params=payload, data=image, timeout=60)
    print(r.status_code, r.url)


# if __name__ == "__main__":
#     time = datetime.now()
#     poslji_meritev(20.0, time, "TEMP1")
#     poslji_sliko("beehive.jpg", time)
