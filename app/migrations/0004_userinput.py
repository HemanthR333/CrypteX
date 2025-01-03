# Generated by Django 4.2.13 on 2024-12-29 20:13

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ("app", "0003_alter_transactiondata_txhash"),
    ]

    operations = [
        migrations.CreateModel(
            name="UserInput",
            fields=[
                (
                    "id",
                    models.BigAutoField(
                        auto_created=True,
                        primary_key=True,
                        serialize=False,
                        verbose_name="ID",
                    ),
                ),
                ("asset_name", models.CharField(max_length=100)),
                ("genre", models.CharField(max_length=100)),
                ("artist_name", models.CharField(max_length=100)),
            ],
        ),
    ]
