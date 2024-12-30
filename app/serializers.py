from .models import TransactionData  # Add this line to import the Transaction model
from rest_framework import serializers  # Add this line to import the serializers module

class TransactionSerializer(serializers.ModelSerializer):
    class Meta:
        model = TransactionData  # Now this will work because the model is imported
        fields = '_all_'