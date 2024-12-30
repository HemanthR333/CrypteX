# admin.py
import csv
from django.contrib import admin
from .models import TransactionData



@admin.register(TransactionData)
class TransactionDataAdmin(admin.ModelAdmin):
    list_display = ('day', 'month', 'year', 'value_normalized', 'blockheight_normalized', 'from_encoded', 'to_encoded')
    search_fields = ('day', 'month', 'year','from_encoded', 'to_encoded')
    list_filter = ('from_encoded', 'to_encoded')

    # def get_urls(self):
    #     urls = super().get_urls()
    #     custom_urls = [
    #         path('new_data.csv', self.admin_site.admin_view(self.upload_csv), name='upload-csv'),
    #     ]
    #     return custom_urls + urls

    # def upload_csv(self, request):
    #     if request.method == "POST":
    #         form = CSVUploadForm(request.POST, request.FILES)
    #         if form.is_valid():
    #             csv_file = form.cleaned_data['csv_file']
    #             decoded_file = csv_file.read().decode('utf-8').splitlines()
    #             reader = csv.DictReader(decoded_file)

    #             for row in reader:
    #                 TransactionData.objects.create(
    #                     day=int(row['Day']),
    #                     month=int(row['Month']),
    #                     year=int(row['Year']),
    #                     value_normalized=float(row['Value_Normalized']),
    #                     blockheight_normalized=float(row['BlockHeight_Normalized']),
    #                     from_encoded=row['From_Encoded'],
    #                     to_encoded=row['To_Encoded']
    #                 )
    #             messages.success(request, "CSV file imported successfully.")
    #             return redirect("..")
    #     else:
    #         form = CSVUploadForm()

    #     context = {
    #         'form': form,
    #         'opts': self.model._meta,
    #         'app_label': self.model._meta.app_label,
    #     }
    #     return render(request, 'admin/csv_upload.html', context)

# Optionally register CSVUpload model if you want to store uploaded files
# @admin.register(CSVUpload)
# class CSVUploadAdmin(admin.ModelAdmin):
#     list_display = ('file',)
