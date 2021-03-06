from datetime import datetime

from fastapi_hypermodel import HyperModel
from pydantic import BaseModel


class Notificare(HyperModel):
    idNotificare: int
    idUserSursa: int
    idUserDestinatie: int
    timestamp: datetime

    class Config:
        orm_mode = True


class NotificarePost(HyperModel):
    idUserSursa: int
    idUserDestinatie: int
    timestamp: datetime

    class Config:
        orm_mode = True


class NotificarePostEmail(HyperModel):
    emailSursa: str
    emailDestinatie: str
    idUserSursa: int
    idUserDestinatie: int
    timestamp: datetime

    class Config:
        orm_mode = True


class Error(BaseModel):
    error_code: int
    error_source: str
    error_reason: str
