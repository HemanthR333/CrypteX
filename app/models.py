# models.py
from django.db import models

class TransactionData(models.Model):
    day = models.IntegerField()
    month = models.IntegerField()
    year = models.IntegerField()
    value_normalized = models.FloatField()
    blockheight_normalized = models.FloatField()
    from_encoded = models.CharField(max_length=255)
    to_encoded = models.CharField(max_length=255)
    txHash = models.CharField(max_length=255,null=False)
    
    def __str__(self):
        return f"{self.year}-{self.month:02d}-{self.day:02d}: {self.value_normalized}"

# class CSVUpload(models.Model):
#     file = models.FileField(upload_to='uploads/')

#     def __str__(self):
#         return self.file.name

class UserInput(models.Model):
    asset_name = models.CharField(max_length=100)
    genre = models.CharField(max_length=100)
    artist_name = models.CharField(max_length=100)

    def __str__(self):
        return self.asset_name
