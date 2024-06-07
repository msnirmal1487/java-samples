import pandas as pd
import numpy as np

input_csv = 'KioskSTAOrders3Months.csv'
output_csv= 'updated_'+input_csv
orders_pd=pd.read_csv(input_csv)
stores_pd=pd.read_csv('StoreState.csv')
# stores_pd.store_number = stores_pd.store_number.astype(str)
# stores_pd.store_number = stores_pd.store_number.apply(lambda x: x.zfill(4))
stores_pd = stores_pd.rename(columns={'store_number': 'StoreNumber'})

# print(stores_pd.tail)
# print(stores_pd.dtypes)
# print(orders_pd.dtypes)
# print(orders_pd.tail)

merged_pd=orders_pd.join(stores_pd.set_index('StoreNumber'), on='StoreNumber', lsuffix="_orders", rsuffix='_stores' )
merged_pd=merged_pd.rename(columns={"states": "shipToState", "state": "storeState"})
print(merged_pd.dtypes)
# print(merged_pd.tail)

# print(stores_pd.query("StoreNumber == 1098"))
# print(orders_pd.query("orderNumber == 9922292180"))
# print(merged_pd.query("orderNumber == 9922292180"))
# /.astype('str').index(x['storeState'])
# merged_pd['isShipToDifferentState'] = merged_pd['shipToState'].str.replace("\"", "").str.replace("[", "").str.replace("]","") == merged_pd['storeState']
# merged_pd['isShipToDifferentState'] = merged_pd['shipToState'].astype(str).find(merged_pd['storeState'])
# print(merged_pd.tail)
print(type(merged_pd['shipToState']))
# print(merged_pd['shipToState'].apply(lambda x: x.index("AA")))
print("asdda".find("d"))
merged_pd['isShipToDifferentState'] = merged_pd.apply(lambda r: str(r.storeState).upper() not in str(r.shipToState).upper(), axis = 1)
merged_pd.to_csv(output_csv)