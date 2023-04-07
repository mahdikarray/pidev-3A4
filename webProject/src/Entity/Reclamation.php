<?php
namespace App\Entity;

use App\Repository\ReclamationRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: ReclamationRepository::class)]
class Reclamation
{
#[ORM\Id]
#[ORM\GeneratedValue]
#[ORM\Column]
private ?int $idReclamation = null;

#[ORM\Column(length:10 )]
#[Assert\NotBlank(message: 'minumum 5 caractères')]
private ?string $object = null;

#[ORM\Column(type: 'text')]
#[Assert\NotBlank(message: 'Description cannot be blank')]
private ?string $description = null;

#[ORM\Column(length: 20)]
#[Assert\NotBlank(message: 'Status cannot be blank')]
private ?string $status = null;

#[ORM\Column(type: 'datetime')]
private ?\DateTime $dateReclamation = null;

public function getIdReclamation(): ?int
{
return $this->idReclamation;
}

public function setIdReclamation(?int $idReclamation): void
{
$this->idReclamation = $idReclamation;
}

public function getObject(): ?string
{
return $this->object;
}

public function setObject(?string $object): void
{
$this->object = $object;
}

public function getDescription(): ?string
{
return $this->description;
}

public function setDescription(?string $description): void
{
$this->description = $description;
}

public function getStatus(): ?string
{
return $this->status;
}

public function setStatus(?string $status): void
{
$this->status = $status;
}

public function getDateReclamation(): ?\DateTime
{
return $this->dateReclamation;
}

public function setDateReclamation(?\DateTime $dateReclamation): void
{
$this->dateReclamation = $dateReclamation;
}
    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="CIN", referencedColumnName="CIN")
     * })
     */
    private $cin;
    public function getCin(): \User
    {
        return $this->cin;
    }
    public function setCin(\User $cin): Reclamation
    {
        $this->cin = $cin;
        return $this;
    }

}