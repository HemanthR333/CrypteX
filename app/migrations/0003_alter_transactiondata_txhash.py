# Generated by Django 4.2.13 on 2024-12-29 19:38

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ("app", "0002_transactiondata_txhash"),
    ]

    operations = [
        migrations.AlterField(
            model_name="transactiondata",
            name="txHash",
            field=models.CharField(max_length=255),
        ),
    ]
