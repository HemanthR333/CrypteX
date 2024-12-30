from django import forms

class MyForm(forms.Form):
    asset_name = forms.CharField(max_length=100, label='Asset Name')
    genre = forms.CharField(max_length=50, label='Genre')
    artist_name = forms.CharField(max_length=50, label='Artist Name')
